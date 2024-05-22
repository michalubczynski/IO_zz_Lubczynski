package vod.repository.mem;

import vod.repository.ProducentDao;
import vod.model.Producent;

import java.util.List;

public class MemProducentDao implements ProducentDao {
    @Override
    public List<Producent> findAll() {
        return SampleData.producents;
    }

    @Override
    public Producent findById(int id) {
        return SampleData.producents.stream().filter(d -> d.getId() == id).findFirst().orElse(null);
    }

    @Override
    public Producent add(Producent d) {
        int max = SampleData.producents.stream().max((d1, d2) -> d1.getId() - d2.getId()).get().getId();
        d.setId(++max);
        SampleData.producents.add(d);
        return d;
    }
}
