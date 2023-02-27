package com.platzi.ui.gui;

import com.platzi.cats.CatService;

import javax.swing.*;
import java.io.IOException;

public class GUI {
    public static void ShowGUI() throws IOException {
        int opcion_menu = -1;
        String[] bottons = {"1. ver gatos", "2. salir"};
        do {
            String opcion = (String) JOptionPane.showInputDialog(null, "Gatitos Java", "Menu principal",
                    JOptionPane.INFORMATION_MESSAGE, null, bottons, bottons[0]);
            switch (opcion) {
                case"1. ver gatos" :
                    CatService.showCat();
                    continue;
                case"2. salir":
                    opcion_menu = 1;
                    break;
                default:
                    break;
            }
        } while (opcion_menu != 1);
    }
}
