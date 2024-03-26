//package com.transportation;
//
//import com.transportation.entity.User;
//import com.transportation.service.UserService;
//import org.junit.jupiter.api.Assertions;
//import org.junit.jupiter.api.Test;
//import org.mockito.Mock;
//import org.springframework.boot.test.context.SpringBootTest;
//
//import java.util.List;
//
//@SpringBootTest
//
//public class UserServiceImplTest {
//
//    @Mock
//    private UserService userService;
//    // createUser method creates a new user with encoded password and returns the user id
//    @Test
//    public void test_createUser_success() {
//        // Arrange
//        User user = new User();
//        user.setFirstName("John");
//        user.setLastName("Doe");
//        user.setEmail("john.doe@example.com");
//        user.setPassword("password");
//
//        // Act
//        Long userId = userService.createUser(user);
//
//        // Assert
//        Assertions.assertNotNull(userId);
//        Assertions.assertEquals(user.getUserId(), userId);
//    }
//
//    // createUser method throws an exception if user is null
//    @Test
//    public void test_createUser_nullUser() {
//        // Arrange
//        User user = null;
//
//        // Act & Assert
//        Assertions.assertThrows(NullPointerException.class, () -> {
//            userService.createUser(user);
//        });
//    }
//
//    // getAllUsers method returns a list of all users
//    @Test
//    public void test_getAllUsers_success() {
//        // Arrange
//
//        // Act
//        List<User> users = userService.getAllUsers();
//
//        // Assert
//        Assertions.assertNotNull(users);
//        Assertions.assertEquals(0, users.size());
//    }
//
//    // getUserById method returns the user with the given id
//    @Test
//    public void test_getUserById_success() {
//        // Arrange
//        User user = new User();
//        user.setFirstName("John");
//        user.setLastName("Doe");
//        user.setEmail("john.doe@example.com");
//        user.setPassword("password");
//        Long userId = userService.createUser(user);
//
//        // Act
//        User retrievedUser = userService.getUserById(userId);
//
//        // Assert
//        Assertions.assertNotNull(retrievedUser);
//        Assertions.assertEquals(userId, retrievedUser.getUserId());
//    }
//
//    // updateUser method updates the user with the given id and returns the updated user
//    @Test
//    public void test_updateUser_success() {
//        // Arrange
//        User user = new User();
//        user.setFirstName("John");
//        user.setLastName("Doe");
//        user.setEmail("john.doe@example.com");
//        user.setPassword("password");
//        Long userId = userService.createUser(user);
//
//        User updatedUser = new User();
//        updatedUser.setFirstName("Jane");
//        updatedUser.setLastName("Smith");
//
//        // Act
//        User result = userService.updateUser(userId, updatedUser);
//
//        // Assert
//        Assertions.assertNotNull(result);
//        Assertions.assertEquals(updatedUser.getFirstName(), result.getFirstName());
//        Assertions.assertEquals(updatedUser.getLastName(), result.getLastName());
//    }
//
//}
