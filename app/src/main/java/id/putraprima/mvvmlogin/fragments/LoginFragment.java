package id.putraprima.mvvmlogin.fragments;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;


import id.putraprima.mvvmlogin.R;
import id.putraprima.mvvmlogin.databinding.FragmentLoginBinding;
import id.putraprima.mvvmlogin.interfaces.LoginCallbacks;
import id.putraprima.mvvmlogin.models.LoginModel;
import id.putraprima.mvvmlogin.viewModels.LoginFragmentViewModel;
import id.putraprima.mvvmlogin.viewModels.LoginFragmentViewModelFactory;

public class LoginFragment extends Fragment implements LoginCallbacks {
    public LoginModel loginModel;
    public LoginFragmentViewModel viewModel;
    private LoginFragmentViewModel userViewModel;
    public LoginFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        loginModel = new LoginModel();
        viewModel = new LoginFragmentViewModel();
        userViewModel = ViewModelProviders.of(requireActivity()).get(LoginFragmentViewModel.class);
        FragmentLoginBinding binding = FragmentLoginBinding.inflate(inflater, container, false);
        binding.setLoginModel(loginModel);
        binding.setLoginViewModel(viewModel);
        binding.setLifecycleOwner(this);
        binding.btnLogin.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                if(viewModel.doLogin()){
                    Navigation.findNavController(view).navigate(R.id.action_loginFragment_to_homeFragment);
                }
                binding.error.setText(loginModel.error);
            }
        });

        return binding.getRoot();
    }

    @Override
    public void onSuccess(String message) {
        Context context = getContext();
        CharSequence success = "Successful";
        Toast.makeText(context, success, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onFailure(String message) {
        Context context = getContext();
        CharSequence success = "Failed";
        Toast.makeText(context, success, Toast.LENGTH_SHORT).show();
    }
}