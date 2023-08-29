# newsjdk20

## Foreign memory
```
O JDK 20 introduziu o conceito de Foreign Memory Access API (também conhecida como Panama Foreign Function & Memory API), que permite acessar memória fora do heap Java de forma segura e eficiente.

Algumas vantagens do uso de Foreign Memory:

Integração mais próxima com código nativo como C, permitindo alocar e acessar estruturas de dados nativas diretamente na JVM.
Possibilidade de alocar grandes blocos de memória off-heap quando necessário, evitando pressão no garbage collector da JVM.
Acesso direto a buffers na memória para operações como I/O, evitando cópias desnecessárias.
Chamadas de funções nativas de forma muito mais eficiente, sem overheads de marshaling.
Código mais simples e legível para interoperabilidade entre Java e nativo.
O funcionamento básico envolve:

Usar a classe MemorySegment para alocar um segmento de memória off-heap.
Mapear esse segmento para uma classe Java que representa a estrutura de dados desejada.
Acessar os dados diretamente na memória via varhandles.
Chamar funções nativas passando o segmento como parâmetro.
Liberar a memória quando não for mais necessária.
Então em resumo, o Foreign Memory Access permite integrar melhor com nativo, alocar memória off-heap quando necessário e interagir com ela de forma mais eficiente e segura na JVM. Isso traz benefícios de performance e menor sobrecarga.
```

## Vector api
```
O Vector API foi introduzido no Java 20 para possibilitar computação vetorial na JVM de forma mais eficiente. Alguns pontos importantes:

Permite executar operações matemáticas em vetores de forma nativa, sem loops. Isso aumenta muito a performance.
Oferece tipos vetoriais como Vector<Integer>, Vector<Double> que representam vetores primitivos.
Tem operações para criar, carregar, armazenar, acessar, iterar e transformar vetores.
As operações são implementadas via intrinsics vetoriais do hardware, como SSE e AVX.
Usa máscara de bits para filtrar operações somente em elementos selecionados.
Provê lançamento eficiente de exceções em bulk.
Pode ser usado para machine learning, processamento gráfico, análise de dados, etc.

var va = Vector.fromArray(double[]);
var vb = Vector.fromArray(int[]);

var vc = va.add(vb); // soma de dois vetores

```

## Scope values
```

O Scoped Values API introduzido no Java 20 provê uma forma melhor de trabalhar com valores vinculados a um escopo ou contexto específico. Alguns pontos importantes:

Permite definir valores (objetos ou primitivos) que existem apenas no escopo de um block de código.
É uma alternativa mais robusta e segura às ThreadLocals.
Os valores são alocados na stack ao invés do heap, o que é mais eficiente.
O ciclo de vida do valor é vinculado ao escopo, não dependendo do programador controlar.
Temos as classes ValueScope, ScopedValue e Binding para trabalhar com escopos.
Exemplo de uso:

try (var scope = new ValueScope()) {

  Binding<String> value = scope.binding("key", "Valor inicial");
  
  value.set("Novo valor");
  
  // faz algo com value
  
} // value é invalidado ao sair do escopo


Os benefícios são:

Código mais simples e legível para valores de escopo
Escopos aninhados funcionam naturalmente
Valores são invalidados e coletados automaticamente
Sem vazamentos de memória
Performance melhor que ThreadLocal
Então o Scoped Values API traz uma forma idiomática ao Java de trabalhar com valores vinculados a escopos de código.
```

vc.reduceLanes(ADD); // soma elementos do vetor
```