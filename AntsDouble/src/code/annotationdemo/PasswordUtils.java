package code.annotationdemo;

import java.util.List;

/**
 * @Auther: ants_double
 * @Date: 2018-12-16 20:47
 * @Description:
 */
public class PasswordUtils {
    @UseCase(id=47,description = "Password must contain at least one numeric")
    public boolean validatePassword(String password){
        return (password.matches("\\w*\\d\\w*"));
    }
    @UseCase(id=48)
    public String encryptPassword(String password){
        return  new StringBuilder(password).reverse().toString();
    }
    @UseCase(id=49,description = "New passwords can't equal previously used ones")
    public boolean checkForNewPassword(List<String> prevPassword,String password){
        return !prevPassword.contains(password);
    }
}
