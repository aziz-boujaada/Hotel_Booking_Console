import ConsoleUI.AuthMenu;
import ConsoleUI.MainMenu;
import Models.User;
import Services.AuthService;


void main() {

    // get the auth menu

   AuthService authService = new AuthService();

   AuthMenu menu = new AuthMenu(authService);
   menu.showMenu();



}
