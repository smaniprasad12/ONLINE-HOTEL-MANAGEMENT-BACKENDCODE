package com.example.OwnerMicroservices;

import com.example.OwnerMicroservices.entity.SetRates;
import com.example.OwnerMicroservices.repository.SetRatesRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

@SpringBootTest
class OwnerMicroservicesApplicationTests {

	@Autowired
	SetRatesRepository setRatesRepository;

	@Test
	public  void saveSetRates(){
		SetRates setrates=SetRates.builder()
				.id(15)
				.guest(5)
				.days(3)
				.extension(2)
				.nightPrice(5000)
				.build();
		setRatesRepository.save(setrates);

		Assertions.assertThat(setrates.getId()).isGreaterThan(0);

	}
	@Test
	public  void updatesetrate(){
		SetRates setrates=setRatesRepository.findById(3L).get();
		setrates.setExtension(2);
		setrates.setDays(5);
		SetRates setratesupdated=setRatesRepository.save(setrates);
		Assertions.assertThat(setratesupdated.getDays()).isEqualTo(5);
		Assertions.assertThat(setratesupdated.getExtension()).isEqualTo(2);

	}
	@Test
	public  void getListSetrate(){
		List<SetRates> setrates=setRatesRepository.findAll();
		Assertions.assertThat(setrates.size()).isGreaterThan(0);


	}
	@Test
	public  void getsetratesById(){
		SetRates setrates=setRatesRepository.findById(3L).get();
		Assertions.assertThat(setrates.getId()).isEqualTo(3);


	}
	@Test
	public void deleteSetrate(){
		SetRates setrates=setRatesRepository.findById(4l).get();
		setRatesRepository.delete(setrates);

		SetRates setrates1=null;

		Optional<SetRates> optionalSetRates=setRatesRepository.findById(7L);

		if(optionalSetRates.isPresent()){
			setrates1=optionalSetRates.get();


		}
		Assertions.assertThat(setrates1).isNull();

	}




}
