@Service
public class AuthService {

    private static final String FIXED_PASSWORD = "password";

    public boolean login(String username, String password) {
        return FIXED_PASSWORD.equals(password);
    }
}
