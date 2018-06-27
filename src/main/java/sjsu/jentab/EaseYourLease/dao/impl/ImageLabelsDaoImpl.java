package sjsu.jentab.EaseYourLease.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import sjsu.jentab.EaseYourLease.dao.ImageLabelsDAO;
import sjsu.jentab.EaseYourLease.model.ImageLabels;

import java.util.List;


public class ImageLabelsDaoImpl {

    @Autowired
    ImageLabelsDAO imageLabelsDAO;

    public List<ImageLabels> findByFlatId(String flatId){
        return (List<ImageLabels>)imageLabelsDAO.findByFlatId(flatId);
    }

    public List<ImageLabels> findByLabels(String labels){
        return (List<ImageLabels>)imageLabelsDAO.findByLabels(labels);
    }
}
