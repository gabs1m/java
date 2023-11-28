package controller;

import java.util.ArrayList;

public interface Controller<T, U>{
    public T insert(U parametro);
    public ArrayList<U> select(String a, String...b);
    public T update(U parametro, int a);
    public T delete(int a);
}