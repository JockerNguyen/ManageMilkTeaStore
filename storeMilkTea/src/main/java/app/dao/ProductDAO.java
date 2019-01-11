package app.dao;

import java.util.List;

import app.model.Product;

public interface ProductDAO extends BaseDAO<Integer, Product> {
	List<Product> loadAllProduct();

}