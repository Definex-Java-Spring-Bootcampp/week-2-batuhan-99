import java.util.List;
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/{email}/applications")
    public ResponseEntity<List<Application>> getUserApplications(@PathVariable String email) {
        User user = userService.getUserByEmail(email);
        List<Application> applications = user.getApplicationList();
        return new ResponseEntity<>(applications, HttpStatus.OK);
    }
}