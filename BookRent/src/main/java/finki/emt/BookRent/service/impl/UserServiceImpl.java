package finki.emt.BookRent.service.impl;
import finki.emt.BookRent.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl{

    private final UserRepository userRepository;
    //private final PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
        //this.passwordEncoder = passwordEncoder;
    }

//    @Override
//    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
//        return userRepository.findByUsername(s).orElseThrow(() -> new UsernameNotFoundException(s));
//    }

//    @Override
//    public User register(String username, String password, String repeatPassword, String name, String surname, Role userRole) {
//        if (username == null || username.isEmpty() || password == null || password.isEmpty())
//            throw new InvalidUsernameOrPasswordException();
//        if (!password.equals(repeatPassword))
//            throw new PasswordsDoNotMatchException();
//        if (this.userRepository.findByUsername(username).isPresent())
//            throw new UsernameAlreadyExistsException(username);
//        User user = new User(username, passwordEncoder.encode(password), name, surname, userRole);
//        return userRepository.save(user);
//    }

}
