package id.putraprima.mvvmlogin.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.navigation.Navigation;

import id.putraprima.mvvmlogin.R;

public class SplashFragment extends Fragment {

    private static int SPLASH_TIME_OUT = 3000;

    public SplashFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if(getActivity()!=null){
                    Fragment login = new LoginFragment();
                    getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.loginFragment, login, "login");
                }
            }
        }, SPLASH_TIME_OUT);
        return inflater.inflate(R.layout.fragment_splash, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if(getActivity()!=null){
                    Navigation.findNavController(view).navigate(R.id.action_splashFragment_to_loginFragment);
                }
            }
        }, SPLASH_TIME_OUT);
    }
}