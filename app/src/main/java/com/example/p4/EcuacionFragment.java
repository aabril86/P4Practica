package com.example.p4;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.p4.databinding.FragmentEcuacionBinding;

public class EcuacionFragment extends Fragment {
    private FragmentEcuacionBinding binding;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return (binding = FragmentEcuacionBinding.inflate(inflater, container, false)).getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        final EcuacionViewModel ecuacionViewModel = new ViewModelProvider(this).get(EcuacionViewModel.class);

        binding.calcular.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                float x2 = Float.parseFloat(binding.x2.getText().toString());
                float x = Float.parseFloat(binding.x.getText().toString());
                float num = Float.parseFloat(binding.num.getText().toString());

                ecuacionViewModel.calcular(x2,x,num);
            }
        });

        ecuacionViewModel.resultat.observe(getViewLifecycleOwner(), new Observer<Double>(){

            @Override
            public void onChanged(Double resultat) {
                binding.resultat.setText(String.format("%.2f", resultat));
            }
        });
    }
}