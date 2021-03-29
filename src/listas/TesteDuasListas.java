package listas;

public class TesteDuasListas {
    public static void main(String[] args){
        System.out.println("TESTE COM LISTAS DE AMBAS AS CLASSES");
        System.out.println("\nJoão e Maria vão ao supermercado, com uma única lista de compras.");
        Lista<String> lista = new ListaEncadeada<>();
        lista.inserir("arroz");
        lista.inserir("batata");
        lista.inserir("café");
        lista.inserir("detergente");
        System.out.println("Esperado arroz, batata, café, detergente = "+lista.exibir());
        System.out.println("\nMaria lembrou que também precisava de fósforos e anotou na lista.");
        lista.inserir("fósforos");
        System.out.println("Esperado arroz, batata, café, detergente, fósforos = "+lista.exibir());

        System.out.println("João passou na frente da gôndola dos cereais e verificou se arroz e feijão estavam na lista");    
        int pos = lista.buscar("arroz");
        System.out.println("Esperado 0 = "+pos);
        pos = lista.buscar("feijão");
        System.out.println("Esperado -1 = "+pos);
        System.out.println("Como arroz estava na lista, pegou arroz e riscou da lista.");    
        lista.retirar("arroz");
        System.out.println("Agora a lista tem (Esperado batata, café, detergente, fósforos) = "+lista.exibir());
        
        System.out.println("\nMaria lembrou que já havia outra lista de supermercado, que estava em seu bolso:");
        Lista<String> lista2 = new ListaEstatica<>();
        lista2.inserir("tomate");
        lista2.inserir("cebola");
        lista2.inserir("cenoura");
        System.out.println("Lista 2(Array) Esperado tomate,cebola,cenoura = "+lista2.exibir());
        System.out.println("Como estava na frente da gôndola da cebola, já pegou e tirou da lista, mas lembrou que também precisava de ovos:");
        lista2.retirar("cebola");
        lista2.inserir("ovos");
        System.out.println("Esperado tomate,cenoura,ovos = "+lista2.exibir());
        
        System.out.println("\nJoão fez uma cópia de sua lista");
        Lista<String> lista3, lista3A;
        lista3 = lista.copiar();
        System.out.println("Lista copiada de João Esperado batata,café,detergente,fósforos = "+lista3.exibir());
        System.out.println("\nComo estavam com pressa, resolveram juntar as duas listas");
        lista.concatenar(lista2);
        System.out.println("Lista João+Maria Esperado batata,café,detergente,fósforos,tomate,cenoura,ovos = "+lista.exibir());
        lista2.concatenar(lista3);
        System.out.println("Lista Maria+João Esperado tomate,cenoura,ovos,batata,café,detergente,fósforos = "+lista2.exibir());

        System.out.println("E aí fizeram uma confusão, juntando tudo de novo... \nEsperado tomate,cenoura,ovos,batata,café,detergente,fósforos, batata,café,detergente,fósforos,tomate,cenoura,ovos");
        lista2.concatenar(lista);
        System.out.println("Nova Lista = "+lista2.exibir());
        
        System.out.println("\nPara resolver o problema, dividiram a lista ");
        Lista<String> lista4, lista5;
        lista4 = lista2.dividir();
        System.out.println("João (dividida) Esperado = batata,café,detergente,fósforos,tomate,cenoura,ovos\n"+lista4.exibir());
        System.out.println("Maria (divisão da Nova lista) Esperado = tomate,cenoura,ovos,batata,café,detergente,fósforos\n"+lista2.exibir());
        System.out.println("E Maria anotou mais uma coisa: chá");
        lista2.inserir("chá");
        System.out.println("Lista Maria Esperado = tomate,cenoura,ovos,batata,café,detergente,fósforos,chá\n"+lista2.exibir());

        System.out.println("E Maria entregou uma cópia da lista para João Esperado = tomate,cenoura,ovos,batata,café,detergente,fósforos,chá");
        lista5 = lista2.copiar();
        System.out.println("João copiada de Maria = "+lista5.exibir());

        System.out.println("Por fim, Maria ainda acrescenta em sua lista mais um item: esponja\nEsperado = tomate,cenoura,ovos,batata,café,detergente,fósforos,chá,esponja");
        lista2.inserir("esponja");
        System.out.println("Lista Maria = "+lista2.exibir());
        System.out.println("Mas do João permanece a mesma\nEsperado = tomate,cenoura,ovos,batata,café,detergente,fósforos,chá,\n\t\t "+lista5.exibir());
        
    }
}