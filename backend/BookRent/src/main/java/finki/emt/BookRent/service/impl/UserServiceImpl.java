package finki.emt.BookRent.service.impl;
import finki.emt.BookRent.repository.UserRepository;
import finki.emt.BookRent.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

}
