package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Machine {

    private List<Item> inventoryB = new ArrayList<>();
    private File inputFile;
    // inputFile is empty bucket that can take in any file put in and use it to load the inventory.

    public Machine(File inputFile){
        this.inputFile = inputFile;
        inventoryB = loadInventory();
    }
    
    
    private List<Item> loadInventory(){
        //File fileToRead= new File(inputFile);
        try(Scanner inventoryFile = new Scanner(inputFile)){
            int counter = 0;
            while (inventoryFile.hasNextLine()) {
                String lineOfText = inventoryFile.nextLine();
                String[] itemLine = lineOfText.split("\\|");
                switch (itemLine[3]){
                    case "Chip":
                        inventoryB.add(new Chips(itemLine[0],itemLine[1], itemLine[2]));
                        break;
                    case "Candy":
                        inventoryB.add(new Candy(itemLine [0],itemLine[1], itemLine [2]));
                        break;
                    case "Drink":
                        inventoryB.add(new Drinks(itemLine [0],itemLine[1], itemLine [2]));
                        break;
                    case "Gum":
                        inventoryB.add(new Gum(itemLine [0],itemLine[1], itemLine [2]));
                        break;
                    default:
                        break;
                }
                counter++;
            }
        }catch(FileNotFoundException exception){
            System.out.println("File not found");
        }
        return inventoryB;
    }
    public void displayInventory() {
        for (Item unit : inventoryB){
            System.out.println(unit);
        }

        }
    }

