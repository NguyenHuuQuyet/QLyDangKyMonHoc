/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

/**
 *
 * @author Minh Hai
 */
public class Run {
    static InsertDefaultData defaultData = new InsertDefaultData();
    public static void main(String[] args) {
        try {
            defaultData.themTK();
            defaultData.themQTV();
            defaultData.themSV();
            defaultData.themGV();           
            defaultData.themMH();
            defaultData.themPH();
            defaultData.themLH();
            defaultData.themSVDangKy();
            defaultData.themGVDangKy();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
