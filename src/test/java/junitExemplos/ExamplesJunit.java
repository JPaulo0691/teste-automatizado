package junitExemplos;

import org.junit.jupiter.api.*;

public class ExamplesJunit {

    @BeforeAll
    public static void beforeAll(){
        System.out.println("Entrei no beforeAll");
    }
    @BeforeEach
    public void before(){
        System.out.println("Entrei no BeforeEach");
        System.out.println("Projeto de automação de testes");
    }

    @Test
    @Disabled
    public void teste02(){
        System.out.println("Teste 02");
    }


    @Test
    @Tag("thiagoTest")
    public void teste01(){
        System.out.println("Teste 01");
    }

    @AfterEach
    public void after(){
        System.out.println("Entrei no AfterEach");
        System.out.println("Fim do Teste");
    }

    @AfterAll
    public static void aposTodosOsTestes(){
        System.out.println("Entrei no AfterAll");
    }


}
