package com.malitourist.Apigestionregion.Depot;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.malitourist.Apigestionregion.Modele.Region;

public interface DepotRegion extends JpaRepository<Region, Long> {
	@Query(value = "SELECT nom, langue  FROM malitourist_region.region", nativeQuery = true)
    Iterable<Object[]> listeRegionSansPays();

}
