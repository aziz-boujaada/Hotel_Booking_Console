import ConsoleUI.AuthMenu;
import ConsoleUI.MainMenu;


void main() {

   MainMenu mainMenu = new MainMenu();
   mainMenu.menu();
    // get the auth menu
   AuthMenu menu = new AuthMenu() ;
   menu.showMenu() ;



}
