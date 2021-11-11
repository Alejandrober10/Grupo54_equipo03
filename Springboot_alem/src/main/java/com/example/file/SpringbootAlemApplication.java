package com.example.file;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import com.example.file.controller.CSVController;


/*

INSERT INTO authority (id,authority) VALUES (1,"ROLE_ADMIN");
INSERT INTO authority (id,authority) VALUES (2,"ROLE_USER");

INSERT INTO usuarios (id,enabled,password,username) 
VALUES(1,0b1,"$2a$04$rtiGhEOfRS7ZfHFL2a1I5eEcYtjwo.5sq1hYgIFu9W0s0BS3gxwWy","admin");

INSERT INTO authorities_users (usuario_id, authority_id) VALUES (1,1);
INSERT INTO authorities_users (usuario_id, authority_id) VALUES (1,2);



 */


@SpringBootApplication
public class SpringbootAlemApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootAlemApplication.class, args);
	}

}
