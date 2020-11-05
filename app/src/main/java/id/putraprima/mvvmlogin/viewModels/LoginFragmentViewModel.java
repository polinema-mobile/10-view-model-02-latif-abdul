package id.putraprima.mvvmlogin.viewModels;

import android.app.AlertDialog;
import android.app.Dialog;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;

import androidx.lifecycle.ViewModel;

import id.putraprima.mvvmlogin.interfaces.LoginCallbacks;
import id.putraprima.mvvmlogin.models.LoginModel;

public class LoginFragmentViewModel extends ViewModel {
    private LoginModel loginModel;
    private LoginCallbacks loginCallbacks;

    public LoginFragmentViewModel() {
    }

    public LoginModel getLoginModel() {
        return loginModel;
    }

    public void setLoginModel(LoginModel loginModel) {
        this.loginModel = loginModel;
    }

    public LoginCallbacks getLoginCallbacks() {
        return loginCallbacks;
    }

    public void setLoginCallbacks(LoginCallbacks loginCallbacks) {
        this.loginCallbacks = loginCallbacks;
    }

    public LoginFragmentViewModel(LoginCallbacks loginCallbacks) {
        this.loginModel = new LoginModel();
        this.loginCallbacks = loginCallbacks;
    }

//    public TextWatcher emailTextWatcher(){
//        return new TextWatcher() {
//            @Override
//            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
//
//            }
//
//            @Override
//            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
//
//            }
//
//            @Override
//            public void afterTextChanged(Editable editable) {
//                loginModel.setEmail(editable.toString());
//            }
//        };
//    }
//
//    public TextWatcher passwordTextWatcher(){
//        return new TextWatcher() {
//            @Override
//            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
//
//            }
//
//            @Override
//            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
//
//            }
//
//            @Override
//            public void afterTextChanged(Editable editable) {
//                loginModel.setPassword(editable.toString());
//            }
//        };
//    }

    public void onLoginBtnClick(View view){
        if(this.doLogin()){
            loginCallbacks.onSuccess("Successful");
        }
        else{
            loginCallbacks.onFailure(loginModel.error);
        }
    }

    public boolean isvalid(){
        return !TextUtils.isEmpty(loginModel.getEmail()) && !TextUtils.isEmpty(loginModel.getEmail());
    }

    public boolean doLogin(){
        if(!cekEmail()){
            loginModel.error += " Email salah";
            return false;
        }
        if(!cekPassword()){
            loginModel.error += " Password salah";
            return false;
        }
        return true;
    }

    public boolean cekEmail(){
        if(loginModel.getEmail() == "grim.culver@gmail.com"){
            return true;
        }
        return false;
    }

    public boolean cekPassword(){
        if(loginModel.getPassword() == "Wx6vlwrsG"){
            return true;
        }
        return false;
    }

}
