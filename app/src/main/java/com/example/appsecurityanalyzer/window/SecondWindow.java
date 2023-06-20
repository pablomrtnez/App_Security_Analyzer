package com.example.appsecurityanalyzer.window;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;

import com.example.appsecurityanalyzer.R;
import com.example.appsecurityanalyzer.databinding.FragmentSecondBinding;
import com.example.appsecurityanalyzer.dto.AppDetailsDto;
import com.example.appsecurityanalyzer.dto.AppInfo;
import com.example.appsecurityanalyzer.logic.JSONHelper;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SecondWindow extends Fragment {

    private FragmentSecondBinding binding;
    private final Set<AppInfo> packageNames = new HashSet<>();
    private final List<AppInfo> filteredPackageNames = new ArrayList<>();
    private ArrayAdapter<AppInfo> adapter;
    private EditText searchEditText;
    private final Gson gson = new Gson();
    private CheckBox checkboxNA;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentSecondBinding.inflate(inflater, container, false);

        // Obtener la lista de todas las aplicaciones instaladas
        packageNames.clear();
        filteredPackageNames.clear();
        obtainAllApps();

        return binding.getRoot();
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // Obtener una referencia al EditText de búsqueda
        searchEditText = view.findViewById(R.id.search_edit_text);

        // Obtener una referencia al CheckBox
        checkboxNA = view.findViewById(R.id.checkbox_na);
        checkboxNA.setOnCheckedChangeListener((buttonView, isChecked) -> {
            // Filtrar la lista de paquetes nuevamente cuando se cambie el estado del CheckBox
            filterPackageList();
        });

        // Copiar la lista original de packageNames en filteredPackageNames
        filteredPackageNames.addAll(packageNames);

        // Ordenar la lista filtrada por seguridad al principio
        Collections.sort(filteredPackageNames, (info1, info2) -> {
            String security1 = info1.getSecurityInfo();
            String security2 = info2.getSecurityInfo();
            return security1.compareToIgnoreCase(security2);
        });

        // Crear un adaptador para la lista de paquetes
        createAdapter();

        // Asignar el adaptador al ListView
        ListView listView = view.findViewById(R.id.listView1);
        listView.setAdapter(adapter);

        // Agregar un TextWatcher al EditText de búsqueda
        searchEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                // No se utiliza
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                // Filtrar la lista de paquetes en función del texto ingresado
                filterPackageList();
            }

            @Override
            public void afterTextChanged(Editable s) {
                // No se utiliza
            }
        });

        // Aplicar el filtro inicialmente
        filterPackageList();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    private void obtainAllApps() {
        PackageManager pm = requireActivity().getPackageManager();
        List<ApplicationInfo> apps = pm.getInstalledApplications(PackageManager.GET_META_DATA);
        for (ApplicationInfo packageInfo : apps) {
            if ((packageInfo.flags & ApplicationInfo.FLAG_SYSTEM) != 0) {
                // Si es una aplicación del sistema, se omite.
                continue;
            }
            String packageName = packageInfo.packageName;
            AppInfo appInfo = new AppInfo(packageName, null);
            if (!packageNames.contains(appInfo)) {
                packageNames.add(appInfo);

                // Obtener el JSON de los detalles de la aplicación y asignar la información de seguridad
                String json = JSONHelper.loadJSONFromAsset(requireContext(), packageName + ".json");
                AppDetailsDto appDetails = gson.fromJson(json, AppDetailsDto.class);
                String securityInfo;
                if (appDetails != null) {
                    securityInfo = String.valueOf(appDetails.getSeguridad());
                } else {
                    securityInfo = "N/A";
                }

                // Actualizar la información de seguridad en el objeto AppInfo
                appInfo.setSecurityInfo(securityInfo);

                // Agregar la aplicación a la lista solo si no existe previamente
                packageNames.add(appInfo);
            }
        }

        // Ordenar la lista original por seguridad
        List<AppInfo> sortedPackageNames = new ArrayList<>(packageNames);
        Collections.sort(sortedPackageNames, (info1, info2) -> {
            String security1 = info1.getSecurityInfo();
            String security2 = info2.getSecurityInfo();
            return security1.compareToIgnoreCase(security2);
        });

        // Reemplazar la lista original con la lista ordenada
        packageNames.clear();
        packageNames.addAll(sortedPackageNames);

    }

    private void filterPackageList() {
        String searchText = searchEditText.getText().toString().toLowerCase();
        boolean showNA = checkboxNA.isChecked();

        filteredPackageNames.clear();
        if (searchText.isEmpty()) {
            // Si el filtro de búsqueda está vacío, agregar todas las aplicaciones a filteredPackageNames
            filteredPackageNames.addAll(packageNames);
        } else {
            // Si hay texto en el filtro de búsqueda, filtrar la lista de aplicaciones
            for (AppInfo appInfo : packageNames) {
                if (appInfo.getPackageName().toLowerCase().contains(searchText)) {
                    filteredPackageNames.add(appInfo);
                }
            }
        }

        if (!showNA) {
            // Filtrar los elementos "N/A"
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                filteredPackageNames.removeIf(appInfo -> appInfo.getSecurityInfo().equals("N/A"));
            }
        }

        // Ordenar la lista filtrada por seguridad
        Collections.sort(filteredPackageNames, (info1, info2) -> {
            String security1 = info1.getSecurityInfo();
            String security2 = info2.getSecurityInfo();
            return security1.compareToIgnoreCase(security2);
        });

        // Notificar al adaptador que los datos han cambiado después de filtrar y ordenar la lista
        adapter.notifyDataSetChanged();
    }

    private void createAdapter() {
        adapter = new ArrayAdapter<AppInfo>(requireActivity(), R.layout.list_item_two_columns, R.id.package_name_text_view, filteredPackageNames) {
            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                // Obtener o inflar la vista para este elemento de la lista
                View view = convertView;
                if (view == null) {
                    view = LayoutInflater.from(getContext()).inflate(R.layout.list_item_two_columns, parent, false);
                }

                // Obtener el objeto AppInfo para este elemento de la lista
                AppInfo appInfo = getItem(position);

                // Obtener el nombre de la aplicación y la información de seguridad
                String packageName = appInfo.getPackageName();
                String securityInfo = appInfo.getSecurityInfo();

                // Configurar los textos de los TextView para mostrar packageName y seguridad
                TextView packageNameView = view.findViewById(R.id.package_name_text_view);
                packageNameView.setText(packageName);

                TextView securityInfoView = view.findViewById(R.id.security_info_text_view);
                securityInfoView.setText(securityInfo);

                // Verificar el valor de seguridad y establecer el color de texto
                try {
                    double securityValue = Double.parseDouble(securityInfo);
                    if (securityValue < 0.34) {
                        securityInfoView.setTextColor(getResources().getColor(R.color.red));
                    } else if (securityValue >= 0.34 && securityValue < 0.67) {
                        securityInfoView.setTextColor(getResources().getColor(R.color.yellow));
                    } else if (securityValue >= 0.67) {
                        securityInfoView.setTextColor(getResources().getColor(R.color.green));
                    }
                } catch (NumberFormatException e) {
                    // Manejar la excepción en caso de que el valor no sea un número válido
                    securityInfoView.setTextColor(getResources().getColor(R.color.black));
                }

                // Agregar un OnClickListener a la vista para navegar a la ventana de detalles
                view.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        // Crear un Bundle y establecer el valor de packageName en el Bundle
                        Bundle bundle = new Bundle();
                        bundle.putString("appName", packageName);

                        // Navegar a ThirdWindow y pasar el Bundle como un argumento de navegación
                        NavController navController = NavHostFragment.findNavController(SecondWindow.this);
                        navController.navigate(R.id.action_SecondWindow_to_ThirdWindow, bundle);
                    }
                });

                return view;
            }
        };
    }

}
