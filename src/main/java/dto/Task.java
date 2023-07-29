package dto;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class Task {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int Id;
	String TaskName;
	String TaskDescription ;
	LocalDate taskdate;
	LocalDate completeionDate;
	boolean status;

}
