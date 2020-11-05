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
                double x2 = Float.parseFloat(binding.x2.getText().toString());
                double x = Float.parseFloat(binding.x.getText().toString());
                double num = Float.parseFloat(binding.num.getText().toString());

                ecuacionViewModel.calcular(x2,x,num);
            }
        });

        ecuacionViewModel.resultat.observe(getViewLifecycleOwner(), new Observer<Double>(){

            @Override
            public void onChanged(Double resultat) {
                binding.resultat.setText(String.format("%.2f", resultat));
            }
        });

        ecuacionViewModel.errorX2.observe(getViewLifecycleOwner(), new Observer<Double>() {
            @Override
            public void onChanged(Double x2Cero) {
                if(x2Cero != null){
                    binding.x2.setError("El capital no puede ser igual a " + x2Cero);
                }else {
                    binding.x2.setError(null);
                }
            }
        });

        ecuacionViewModel.errorRaiz.observe(getViewLifecycleOwner(), new Observer<Integer>() {
            @Override
            public void onChanged(Integer raizMinima) {
                if (raizMinima != null){
                    binding.num.setError("El discriminante es inferior a " + raizMinima +", no se puede calcular");
                }else {
                    binding.num.setError(null);
                }
            }
        });
    }
}