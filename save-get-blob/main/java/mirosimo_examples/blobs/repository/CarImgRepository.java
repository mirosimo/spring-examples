package mirosimo_examples.blobs.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import mirosimo_examples.blobs.model.CarImg;



public interface CarImgRepository extends JpaRepository<CarImg, Long> {

}
