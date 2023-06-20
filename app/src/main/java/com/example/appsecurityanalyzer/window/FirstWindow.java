package com.example.appsecurityanalyzer.window;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.example.appsecurityanalyzer.R;
import com.example.appsecurityanalyzer.databinding.FragmentFirstBinding;

public class FirstWindow extends Fragment {

    private FragmentFirstBinding binding;

    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = FragmentFirstBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.btnShowApps.setOnClickListener(view1 -> NavHostFragment.findNavController(FirstWindow.this)
                .navigate(R.id.action_FirstWindow_to_SecondWindow));

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}