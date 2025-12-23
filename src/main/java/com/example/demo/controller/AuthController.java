@RestController
@RequestMapping("/auth")
public class AuthController {

    private final UserService userService;

    public AuthController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/login")
    public ApiResponse<AuthResponse> login(@RequestBody LoginRequest request) {

        // ✅ Validate request
        if (request.getEmail() == null || request.getPassword() == null) {
            return new ApiResponse<>(false, "Email or password is missing", null);
        }

        // ✅ Fetch user
        User user = userService.findByEmail(request.getEmail());

        // ✅ Handle user not found
        if (user == null) {
            return new ApiResponse<>(false, "Invalid email", null);
        }

        // ❌ Password not checked (as you said: no security)
        AuthResponse response = new AuthResponse(
                "DUMMY_TOKEN",
                user.getId(),
                user.getEmail(),
                user.getRole()
        );

        return new ApiResponse<>(true, "Login successful (No Security)", response);
    }
}
