package com.platzi.cats;

import javax.swing.*;
import java.io.IOException;

public class CatService {
    public static void showCat() throws IOException {
        Cat cat = new Cat();
        String menu = "Opciones: \n1.- Ver otra imagen \n2.-Favorito \n3.-Volver ";
        String bottons[] = {"Ver Otra imagen", "Favoritos", "Volver"};
        String id = cat.getId();
        String option = (String) JOptionPane.showInputDialog(null, menu, id, JOptionPane.INFORMATION_MESSAGE
                , CatDAO.getCat(), bottons, bottons[0]);

        int seleccion = -1;

        for (int i = 0; i < bottons.length; i++) {
            if (option.equals(bottons[i])) {
                seleccion = i;
            }
        }
        switch (seleccion) {
            case 0:
                showCat();
                break;
            case 1:
                CatDAO.addCatToFavorite();
                break;
            default:
                break;
        }
    }
}