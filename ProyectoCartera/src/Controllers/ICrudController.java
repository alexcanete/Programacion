package Controllers;

import java.sql.*;
import java.util.List;

public interface ICrudController <T>{
    public List<T> getLista();

	public void setLista(List<T> lLista);

	public boolean add(T oObject, Connection oConnection);

	public boolean remove(T oObject, Connection oConnection);

	public boolean update(T oObject, Connection oConnection);

	public List<T> readAll();
}
