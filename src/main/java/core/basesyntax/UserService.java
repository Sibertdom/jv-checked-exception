package core.basesyntax;

public class UserService {
    private final PasswordValidator passwordValidator = new PasswordValidator();

    public void registerUser(User user) {
        System.out.println("Спроба реєстрації користувача: " + user.getEmail());

        try {
            // Викликаємо метод валідації, який кидає Checked Exception
            passwordValidator.validate(user.getPassword(), user.getRepeatPassword());

            // Якщо виключення не кинуто, реєстрація успішна
            saveUser(user);

        } catch (PasswordValidationException e) {
            // Обробляємо Checked Exception згідно з вимогою завдання
            System.out.println("Your passwords are incorrect. Try again.");
            // Можна додати логування для відлагодження
            // System.err.println("Деталі помилки: " + e.getMessage());
        }
    }

    public void saveUser(User user) {
        System.out.println("User " + user.toString() + " was saved to database!!!");
    }
}
