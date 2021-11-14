package Project;

/**
 * Represents a class that prepoulates the database.
 */

public class PrePopulate {

    /**
     * Method that prepopulates the database.
     * @param menu Menu of the restaurant to be populated.
     * @param staffList List of staff to be populated.
     */

    public static void prepopulate(Menu menu, StaffList staffList) {
        // Polulating Main Dish
        menu.getMain().add(new MenuItems("M1","Japanese Steak","Grilled beef sirloin",21.9));
        menu.getMain().add(new MenuItems("M2","Chicken Teriyaki","Sizzling grilled chicken breast with teriyaki sauce",14.9));
        menu.getMain().add(new MenuItems("M3","Salmon Teriyaki","Grilled salmon with teriyaki sauce",16.9));
        menu.getMain().add(new MenuItems("M4","Unagi Donburi","Eel with teriyaki sauce on rice",17.9));
        menu.getMain().add(new MenuItems("M5","Chicken Donburi","Chicken and vegetables with egg on rice",14.9));
        menu.getMain().add(new MenuItems("M6","Beef Donburi","Marinated beef and vegetables with egg on rice",14.9));
        menu.getMain().add(new MenuItems("M7","Sashimi Donburi","Vegetables topped mixed with chopped raw fish on rice",15.9));
        menu.getMain().add(new MenuItems("M8","Shrimp Tempura","Deep Fried shrimps and vegetables",15.9));

        // Polulating Desserts
        menu.getDes().add(new MenuItems("D1","Apple Pie","Flakey pastry crust packed with fresh apples",5.25));
        menu.getDes().add(new MenuItems("D2","Peach pie","Homemade peach pie filling, encased in a pastry crust",6.0));
        menu.getDes().add(new MenuItems("D3","Cherry Pie","Cherry and almond featuring a crunchy topping",4.5));
        menu.getDes().add(new MenuItems("D4","Banana Pie","Graham cracker pie crust filled with banana pudding",5.5));
        menu.getDes().add(new MenuItems("D5","Chocolate Mint Pie","Oreo cookie crust, filled with minty cream cheese",5.5));
        menu.getDes().add(new MenuItems("D6","Vanilla Cupcake","Classic Madagascar bourbon vanilla cupcake",3.5));
        menu.getDes().add(new MenuItems("D7","Chocolate Cupcake","Valrhana chocolate cupcake topped with seasonal decoration",3.5));
        menu.getDes().add(new MenuItems("D8","Red Velvet Cupcake","Classic red velvet cupcake with a vanilla cream cheese",3.5));

        // Polulating Bevarages
        menu.getBev().add(new MenuItems("B1","Black Coffee","Black Coffee",2.5));
        menu.getBev().add(new MenuItems("B2","White Coffee","White Coffee",3.0));
        menu.getBev().add(new MenuItems("B3","Vietnamese Filter Coffee","Vietnamese Filter Coffee",3.0));
        menu.getBev().add(new MenuItems("B4","Apple Tea","Apple Tea",3.5));
        menu.getBev().add(new MenuItems("B5","Fruit Punch","Fig, Orange, Pineapple",6.5));
        menu.getBev().add(new MenuItems("B6","Sapa Punch","Orange, Lemon, Pineapple, Banana, Sugar",4.0));
        menu.getBev().add(new MenuItems("B7","Chocolate Banana","Cocoa, Banana, Milk, Sugar",4.5));
        menu.getBev().add(new MenuItems("B8","Mango Lasse","Mango, Yogurt, Sugar",4.5));

        // Populating Staff
        staffList.getStaffArray().add(new Staff(1,"Pikachu"));
        staffList.getStaffArray().add(new Staff(2,"Bulbasaur"));
        staffList.getStaffArray().add(new Staff(3,"Charmander"));

    }
}
