package model;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author HP PAVILION
 */
public class Ringkasan extends Buku {

    private int idRingkasan, status, userId;

    private String content, peringkas;

    public Ringkasan() {
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getIdRingkasan() {
        return idRingkasan;
    }

    public void setIdRingkasan(int idRingkasan) {
        this.idRingkasan = idRingkasan;
    }

    @Override
    public int getStatus() {
        return status;
    }

    @Override
    public void setStatus(int status) {
        this.status = status;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getPeringkas() {
        return peringkas;
    }

    public void setPeringkas(String peringkas) {
        this.peringkas = peringkas;
    }

}
