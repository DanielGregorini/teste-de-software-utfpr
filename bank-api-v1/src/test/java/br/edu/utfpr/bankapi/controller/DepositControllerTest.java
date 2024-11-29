package br.edu.utfpr.bankapi.controller;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureTestEntityManager;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import br.edu.utfpr.bankapi.model.Account;
import jakarta.transaction.Transactional;

@SpringBootTest
@AutoConfigureMockMvc
@AutoConfigureTestEntityManager
@Transactional
public class DepositControllerTest {

    @Autowired
    private MockMvc mvc; // Injetando MockMvc corretamente

    @Autowired
    EntityManeger entityManeger;

    @Test
    void deveriaRetornar400ParaRequisicaoInvalida() throws Exception {
        // Arrange
        var json = "{}"; // Dados para requisição HTTP

        

        // Act
        var res = mvc.perform(
                MockMvcRequestBuilders.post("/transaction/deposit")
                        .content(json)
                        .contentType(MediaType.APPLICATION_JSON))
                .andReturn().getResponse();

        // Assert
        Assertions.assertEquals(400, res.getStatus());
    }

    @Test
    void deveriaRetornar201ParaRequisicaoValida() throws Exception {
        // Criando uma instância de Account para a requisição válida
        Account account = new Account("felizidade", 943432, 0, 1000);

        // Arrange
        var json = """
        {
            "accountName": "felizidade",
            "accountNumber": 943432,
            "balance": 0,
            "depositAmount": 1000
        }
        """; // Dados para a requisição HTTP

        // Act
        var res = mvc.perform(
                MockMvcRequestBuilders.post("/transaction/deposit")
                        .content(json)
                        .contentType(MediaType.APPLICATION_JSON))
                .andReturn().getResponse();

        // Assert
        Assertions.assertEquals(201, res.getStatus());
    }
}
