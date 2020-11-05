package id.putraprima.mvvmlogin.viewModels;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import id.putraprima.mvvmlogin.interfaces.LoginCallbacks;

public class LoginFragmentViewModelFactory extends ViewModelProvider.NewInstanceFactory {
    private LoginCallbacks loginCallbacks;

    public LoginFragmentViewModelFactory(LoginCallbacks loginCallbacks) {
        this.loginCallbacks = loginCallbacks;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        return (T)new LoginFragmentViewModel(loginCallbacks);
    }
}
