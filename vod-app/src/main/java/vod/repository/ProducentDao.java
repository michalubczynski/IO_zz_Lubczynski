package vod.repository;

import vod.model.Producent;

import java.util.List;

public interface ProducentDao {

    List<Producent> findAll();

    Producent findById(int id);

    Producent add(Producent p);


}
