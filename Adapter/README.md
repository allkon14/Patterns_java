Шаблон адаптера позволяет классам работать вместе, что в противном случае было бы невозможно из-за несовместимых интерфейсов.

Концепция
Шаблон имеет дело по крайней мере с двумя несовместимыми иерархиями наследования. В системе клиенты знают, как вызывать методы в программном обеспечении. Эти методы могут следовать иерархии наследования.
Теперь предположим, что вам нужно обновить свою систему и перейти на новое наследование иерархия. Когда вы делаете это, вы не хотите заставлять своих клиентов осваивать новый
способ доступа к программному обеспечению. 
Итак, что вы можете сделать? Решение простое: вы пишете адаптер, который принимает клиентские запросы и преобразует эти запросы в форму, понятную методам в новой иерархии. В результате клиенты могут пользоваться обновленным
программным обеспечением без каких-либо хлопот. Используя этот шаблон, вы делаете два **несовместимых** интерфейса **совместимыми**, чтобы они могли работать вместе.


В примере есть две иерархии, одна для прямоугольников и одна для треугольников. В интерфейсе есть два метода, называемых RectInterface:
calculateArea() и AboutMe().

Интерфейс TriInterface имеет два метода, называемых calculatetriangleАrea() и aboutTriangle(). 

Теперь предположим, что вам нужно вычислить площадь треугольника, используя иерархию прямоугольников. Как вы можете поступить дальше? Используем адаптер для решения этой проблемы. 

**Удобство**: Вы не вносите никаких изменений ни в какую иерархию. 

Помимо этого преимущества, вы также можете расширить преимущества использования адаптера. 
Например, предположим, что вам нужно иметь большое количество прямоугольников в приложении, но существует ограничение на количество прямоугольников, которые вы можете создать. 
(предположим, что вам разрешено создавать максимум 5 прямоугольников и 10 треугольников, но при запуске приложения в определенных сценариях вам может потребоваться предоставить 10 прямоугольников.)
В таких случаях, используя этот шаблон, вы можете использовать некоторые объекты triangle, которые могут вести себя как объекты rectangle. 
Этот подход показывает, что вы можете изменить тело метода в соответствии с вашими потребностями. 
