package com.ll;

import com.ll.db.DBConnection;

import java.util.Scanner;

public class Container {
    private static Scanner sc;
    private static DBConnection dbConnection;
    private static int memId = -1;


    public static void init() {sc = new Scanner(System.in);}
    public static void close() { sc.close();}
    public static Scanner getSc() {return sc;}
    public static DBConnection getDBConnection() {
        if(dbConnection == null){
            dbConnection = new DBConnection();
        }
        return dbConnection;
    }
    // static 메서드: 전역에서 호출 가능
    public static void setMemberId(int id) {
        memId = id;
    }

    public static int getMemberId(){
        return memId;
    }
}
