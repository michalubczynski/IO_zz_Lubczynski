package vod.repository.data;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;
import vod.model.Producent;
import vod.repository.ProducentDao;

import java.util.List;

@Repository
@RequiredArgsConstructor
@Primary
public class DataProducentDao implements ProducentDao {

    private final ProducentRepository repository;


    @Override
    public List<Producent> findAll() { return repository.findAll(); }

    @Override
    public Producent findById(int id) { return repository.findById(id).orElse(null); }

    @Override
    public Producent add(Producent p) { return repository.save(p); }
}
