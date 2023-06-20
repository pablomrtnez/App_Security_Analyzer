package com.example.appsecurityanalyzer.window;

import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.appsecurityanalyzer.R;
import com.example.appsecurityanalyzer.databinding.FragmentThirdBinding;
import com.example.appsecurityanalyzer.dto.AppDetailsDto;
import com.example.appsecurityanalyzer.logic.JSONHelper;
import com.google.gson.Gson;

public class ThirdWindow extends Fragment {

    String appName;
    private FragmentThirdBinding binding;

    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = FragmentThirdBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        TableLayout tableLayout = getView().findViewById(R.id.table_layout);

        // Recupera el valor de appName del Bundle de argumentos
        Bundle args = getArguments();
        if (args != null) {
            if (args.getString("appName").contains("-")){
                String[] app = args.getString("appName").split(" - ");
                appName = app[0];
            } else {
                appName = args.getString("appName");
            }
        }

        Gson gson = new Gson();
        String json = JSONHelper.loadJSONFromAsset(getContext(), appName + ".json");

        if (json == "") {
            TextView notImplementedTextView = new TextView(getContext());
            notImplementedTextView.setText("Details not available yet. If you want to colaborate please " +
                    "go to GitHub and add the details for this app");
            tableLayout.addView(notImplementedTextView);
            return;
        }
        AppDetailsDto appDetails = gson.fromJson(json, AppDetailsDto.class);

        // Crea la tabla con todos los detalles de la app selecionada
        createTable(tableLayout, appDetails);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    private void createTable(TableLayout tableLayout, AppDetailsDto appDetails) {
        // Ajusta el padding y el color de fondo de la tabla
        tableLayout.setPadding(10, 10, 10, 10); // Ajusta el padding a 10 píxeles
        tableLayout.setBackgroundColor(Color.WHITE); // Establece el color de fondo a blanco

        // Crea la fila del nombre de la aplicación
        createAppNameRow(tableLayout, appDetails);

        // Crea la fila de seguridad
        createSecurityRow(tableLayout, appDetails);

        // Crea la fila de registro
        createRegisterRow(tableLayout);

        // Agrega cada detalle de registro como una fila separada
        addDetailRow(tableLayout, "Registro con Google", appDetails.getRegistroConGoogle());
        addDetailRow(tableLayout, "Registro con Facebook", appDetails.getRegistroConFacebook());

        addDetailRow(tableLayout, "El proceso de registro pide número de teléfono para asociar cuenta", appDetails.getPideNumeroTelefono());
        addDetailRow(tableLayout, "El proceso de registro pide autenticar el número de teléfono", appDetails.getAutenticaNumeroTelefono());

        addDetailRow(tableLayout, "El proceso de registro pide correo electrónico para asociar cuenta", appDetails.getPideCorreoElectronico());
        addDetailRow(tableLayout, "El proceso de registro pide autenticar el correo electrónico", appDetails.getAutenticaCorreoElectronico());

        addDetailRow(tableLayout, "Longitud mínima de contraseña", appDetails.getLongitudMinimaContrasena());
        addDetailRow(tableLayout, "Longitud máxima de contraseña", appDetails.getLongitudMaximaContrasena());
        addDetailRow(tableLayout, "Obligacion de utilizar minúsculas", appDetails.getObligaMinusculas());
        addDetailRow(tableLayout, "Obligacion de utilizar mayúsculas", appDetails.getObligaMayusculas());
        addDetailRow(tableLayout, "Obligacion de utilizar números", appDetails.getObligaNumeros());
        addDetailRow(tableLayout, "Obligacion de utilizar caracteres especiales", appDetails.getObligaCaracteresEspeciales());

        addDetailRow(tableLayout, "El proceso de registro permite autocompletar campos", appDetails.getPermiteAutocompletarCampos());
        addDetailRow(tableLayout, "El campo de la contaseña dispone de un generador automático de passwords", appDetails.getGeneraContrasenaAutomatica());
        addDetailRow(tableLayout, "El proceso de registro permite guardar la contraseña", appDetails.getPermiteGuardarContrasena());
        addDetailRow(tableLayout, "El proceso de registro pide confirmación de contraseña", appDetails.getPideConfirmacionContrasena());
        addDetailRow(tableLayout, "El proceso de registro dispone de passkeys", appDetails.getTienePasskeys());
        addDetailRow(tableLayout, "El proceso de registro contiene un captcha para verificar que no se trata de una máquina", appDetails.getTieneCaptcha());

        // Crea la fila de login
        createLoginRow(tableLayout);

        // Agrega cada detalle de login como una fila separada
        addDetailRow(tableLayout, "Iniciar sesion con Google", appDetails.getInicioSesionConGoogle());
        addDetailRow(tableLayout, "Iniciar sesion con Facebook", appDetails.getInicioSesionConFacebook());
        addDetailRow(tableLayout, "Iniciar sesion con numero de telefono", appDetails.getInicioSesionConNumeroTelefono());
        addDetailRow(tableLayout, "Iniciar sesion con correo electronico", appDetails.getInicioSesionConCorreoElectronico());
        addDetailRow(tableLayout, "Iniciar sesion con nombre de usuario", appDetails.getInicioSesionConNombreUsuario());
        addDetailRow(tableLayout, "Iniciar sesion con datos biometricos", appDetails.getInicioSesionConDatosBiometricos());

        addDetailRow(tableLayout, "La aplicación dispone de doble factor de autenticación", appDetails.getTieneDobleFactorAutenticacion());
        addDetailRow(tableLayout, "La aplicación pregunta al usuario si desea utilizar doble factor de autenticación", appDetails.getPreguntaDobleFactorAutenticacion());
    }

    private void createAppNameRow(TableLayout tableLayout, AppDetailsDto appDetails) {
        TableRow appNameRow = new TableRow(getContext());
        appNameRow.setPadding(5, 5, 5, 5); // Ajusta el padding de la fila a 5 píxeles
        appNameRow.setBackgroundColor(Color.DKGRAY); // Establece el color de fondo de la fila a gris claro

        TextView appNameLabel = new TextView(getContext());
        appNameLabel.setText("Application name");
        appNameLabel.setLayoutParams(new TableRow.LayoutParams(0, TableRow.LayoutParams.WRAP_CONTENT, 0.7f));
        appNameLabel.setPadding(10, 10, 10, 10); // Ajusta el padding del TextView a 10 píxeles
        appNameLabel.setTextColor(Color.WHITE); // Establece el color de texto a blanco

        TextView appNameValue = new TextView(getContext());
        appNameValue.setText(appDetails.getNombreApp());
        appNameValue.setLayoutParams(new TableRow.LayoutParams(0, TableRow.LayoutParams.WRAP_CONTENT, 0.3f));
        appNameValue.setPadding(10, 10, 10, 10); // Ajusta el padding del TextView a 10 píxeles
        appNameValue.setTextColor(Color.WHITE); // Establece el color de texto a blanco
        appNameValue.setGravity(Gravity.CENTER);

        appNameRow.addView(appNameLabel);
        appNameRow.addView(appNameValue);
        tableLayout.addView(appNameRow);
    }

    private void createSecurityRow(TableLayout tableLayout, AppDetailsDto appDetails) {
        TableRow securityRow = new TableRow(getContext());
        TextView securityLabel = new TextView(getContext());
        securityLabel.setText("Security");
        securityLabel.setLayoutParams(new TableRow.LayoutParams(0, TableRow.LayoutParams.WRAP_CONTENT, 0.7f));
        TextView securityValue = new TextView(getContext());

        if (appDetails.getSeguridad() <= 0.33) {
            securityRow.setBackgroundColor(Color.RED);
            securityValue.setText ("Low");
        } else if (appDetails.getSeguridad() > 0.33 && appDetails.getSeguridad() <= 0.66) {
            securityRow.setBackgroundColor(Color.YELLOW);
            securityValue.setText ("Medium");
        } else if (appDetails.getSeguridad() > 0.66) {
            securityRow.setBackgroundColor(Color.GREEN);
            securityValue.setText ("High");
        }

        securityValue.setLayoutParams(new TableRow.LayoutParams(0, TableRow.LayoutParams.WRAP_CONTENT, 0.3f));
        securityValue.setGravity(Gravity.CENTER);

        securityLabel.setPadding(10, 10, 10, 10); // Ajusta el padding del TextView a 10 píxeles

        securityRow.addView(securityLabel);
        securityRow.addView(securityValue);
        tableLayout.addView(securityRow);
    }

    private void createRegisterRow(TableLayout tableLayout) {
        TableRow registrationRow = new TableRow(getContext());
        registrationRow.setPadding(5, 5, 5, 5); // Ajusta el padding de la fila a 5 píxeles
        registrationRow.setBackgroundColor(Color.LTGRAY); // Establece el color de fondo de la fila a gris claro

        TextView registrationLabel = new TextView(getContext());
        registrationLabel.setText("Register process");
        registrationLabel.setLayoutParams(new TableRow.LayoutParams(0, TableRow.LayoutParams.WRAP_CONTENT, 0.7f));
        registrationLabel.setPadding(10, 10, 10, 10); // Ajusta el padding del TextView a 10 píxeles

        registrationRow.addView(registrationLabel);
        tableLayout.addView(registrationRow);
    }

    private void createLoginRow(TableLayout tableLayout) {
        TableRow loginRow = new TableRow(getContext());
        loginRow.setPadding(5, 5, 5, 5); // Ajusta el padding de la fila a 5 píxeles
        loginRow.setBackgroundColor(Color.LTGRAY); // Establece el color de fondo de la fila a gris claro

        TextView loginLabel = new TextView(getContext());
        loginLabel.setText("Login process");
        loginLabel.setLayoutParams(new TableRow.LayoutParams(0, TableRow.LayoutParams.WRAP_CONTENT, 0.7f));
        loginLabel.setPadding(10, 10, 10, 10); // Ajusta el padding del TextView a 10 píxeles

        loginRow.addView(loginLabel);
        tableLayout.addView(loginRow);
    }

    private void addDetailRow(TableLayout tableLayout, String textoControl, boolean respuestaControl) {
        TableRow row = new TableRow(getContext());
        TextView labelTextView = new TextView(getContext());
        labelTextView.setText(textoControl);
        TextView valueTextView = new TextView(getContext());

        if (respuestaControl) {
            valueTextView.setText("✓");
            valueTextView.setTextColor(Color.GREEN);
        } else {
            valueTextView.setText("X");
            valueTextView.setTextColor(Color.RED);
        }

        valueTextView.setGravity(Gravity.CENTER);

        // Set the layout parameters for the table row
        TableRow.LayoutParams rowParams = new TableRow.LayoutParams();
        rowParams.width = TableRow.LayoutParams.MATCH_PARENT;
        rowParams.height = TableRow.LayoutParams.WRAP_CONTENT;
        rowParams.weight = 1;

        // Set the layout parameters for the label text view
        TableRow.LayoutParams labelParams = new TableRow.LayoutParams();
        labelParams.width = 0;
        labelParams.height = TableRow.LayoutParams.WRAP_CONTENT;
        labelParams.weight = 0.7f;

        // Set the layout parameters for the value text view
        TableRow.LayoutParams valueParams = new TableRow.LayoutParams();
        valueParams.width = 0;
        valueParams.height = TableRow.LayoutParams.WRAP_CONTENT;
        valueParams.weight = 0.3f;

        // Set the layout parameters for the label and value text views
        labelTextView.setLayoutParams(labelParams);
        valueTextView.setLayoutParams(valueParams);

        if (labelTextView.getText().equals("Longitud máxima de contraseña") && respuestaControl) {
            labelTextView.setPadding(10, 10, 10, 10); // Ajusta el padding del TextView a 10 píxeles
            row.setBackgroundColor(Color.parseColor("#FFB3B3")); // Color rojo claro
        }

        if (labelTextView.getText().equals("Longitud máxima de contraseña") && !respuestaControl) {
            valueTextView.setTextColor(Color.GREEN); // Color verde para X
        }

        if (!labelTextView.getText().equals("Longitud máxima de contraseña") && !respuestaControl) {
            labelTextView.setPadding(10, 10, 10, 10); // Ajusta el padding del TextView a 10 píxeles
            row.setBackgroundColor(Color.parseColor("#FFB3B3")); // Color rojo claro
        }

        row.addView(labelTextView);
        row.addView(valueTextView);
        tableLayout.addView(row, rowParams);
    }

}
