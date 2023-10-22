package ru.job4j.ex;

public class UserStore {
    public static User findUser(User[] users, String login) throws UserNotFoundException {
        User user = null;
        for (User us : users) {
            if (login.equals(us.getUsername())) {
                user = us;
                break;
            }
        }
        if (user == null) {
            throw new UserNotFoundException("User not found");
        }
        return user;
    }

    public static boolean validate(User user) throws UserInvalidException {
        if (!user.isValid() || user.getUsername().length() < 3) {
            throw new UserInvalidException("Invalid User");
        }
        return true;
    }

    public static void main(String[] args) {
        User[] users = {
                new User("Konst Karpov", true)
        };
        try {
            User user = findUser(users, "Konst Karpov");
            if (user != null) {
                if (validate(user)) {
                    System.out.println("This user has an access");
                }
            }
        } catch (UserInvalidException ei) {
            ei.printStackTrace();
        } catch (UserNotFoundException en) {
            en.printStackTrace();
        }
    }
}
