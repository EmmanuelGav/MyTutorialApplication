package com.example.mytutorialapplication.ui.dashboard;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.mytutorialapplication.R;
import com.example.mytutorialapplication.databinding.FragmentDashboardBinding;

public class DashboardFragment extends Fragment {

    private DashboardViewModel dashboardViewModel;
    private FragmentDashboardBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        dashboardViewModel =
                new ViewModelProvider(this).get(DashboardViewModel.class);

        binding = FragmentDashboardBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        TextView textNumber1 = binding.number1;
        final TextView textNumber2 = binding.number2;
        final TextView operationMath = binding.operationMath;
        Button buttonEqual = binding.buttonEqual;
        TextView textResult = binding.textResult;

        buttonEqual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Long resultFinal=null;
                Long number1 = Long.valueOf(textNumber1.getText().toString());
                Long number2 = Long.valueOf(textNumber2.getText().toString());
                switch (operationMath.getText().toString()) {
                    case "+":
                        resultFinal = number1 + number2;
                        textResult.setText(resultFinal.toString());
                    case "-":
                        resultFinal = number1 - number2;
                        textResult.setText(resultFinal.toString());
                    case "/":
                        resultFinal = number1 / number2;
                        textResult.setText(resultFinal.toString());
                    case "*":
                        resultFinal = number1 * number2;
                        textResult.setText(resultFinal.toString());
                    default:
                        textResult.setText("No puede ser resuelto");

                }
            }
        });

        dashboardViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
            }
        });
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}