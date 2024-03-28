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
public class Penulis extends Pengguna {

    private ArrayList<Ringkasan> summarizedBooks;

    public Penulis(String fullname, String username, String email, String password) {
        super(fullname, username, email, password);
        this.summarizedBooks = new ArrayList<>();
    }
    
    public void addSummarizedBooks(Ringkasan b) {
        summarizedBooks.add(b);
    }
    
    public ArrayList<Ringkasan> getSummarizedBooks() {
        return summarizedBooks;
    }
}
