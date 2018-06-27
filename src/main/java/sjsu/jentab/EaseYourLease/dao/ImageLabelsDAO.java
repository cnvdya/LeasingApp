package sjsu.jentab.EaseYourLease.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import sjsu.jentab.EaseYourLease.model.ImageLabels;

import java.util.List;

@Component
public interface ImageLabelsDAO extends CrudRepository <ImageLabels,Integer> {
	public List<ImageLabels> findByFlatId(String flatId);
	public List<ImageLabels> findByLabels(String flatId);
}
