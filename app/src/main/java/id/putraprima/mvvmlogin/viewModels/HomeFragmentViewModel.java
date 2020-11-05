package id.putraprima.mvvmlogin.viewModels;

import androidx.lifecycle.ViewModel;

import id.putraprima.mvvmlogin.models.LoginModel;

public class HomeFragmentViewModel extends ViewModel {

    private LoginFragmentViewModel loginViewModel = new LoginFragmentViewModel();
    private LoginModel loginModel = loginViewModel.getLoginModel();

    public void setLoginModel(LoginModel loginModel) {
        this.loginModel = loginModel;
    }

    public String getEmail(){
        return loginModel.getEmail();
    }
}
