package model;


import java.util.ArrayList;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author HP PAVILION
 */
public class Pembaca extends Pengguna {

    private ArrayList<Ringkasan> booksRead;

    public Pembaca(String fullname, String username, String email, String password) {
        super(fullname, username, email, password);
        this.booksRead = new ArrayList<>();
    }

    public void addBooksRead(Ringkasan b) {
        booksRead.add(b);
    }
    
    public ArrayList<Ringkasan> getBooksRead() {
        return booksRead;
    }
    
    
}
