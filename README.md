In your README.md write a short answer to the following questions:

Did you use the same type of route to update patient information and to update an employee department?

No, para la información del paciente usé el verbo PUT y para el dempartment del employee usé el verbo PATCH.

Why did you choose the strategy that you chose?

por que por definicion patch se usa para propiedades específicas del registro, mientras que PUT se usa para modificar toda la informacion del registro.

What are the pros and cons of the strategies you chose for creating these routes?

pros 

- para cambiar toda la información con el método Patch, se pasaría por un método más largo, quizás cambiando las propiedades una por una. 

cons

- con el metodo patch necesitas crear clases para cada propiedad que quieras cambiar, mientras que con el método put solo necesitas crear una clase con todas las propiedades que quieras cambiar.

What are the tradeoffs between PUT and PATCH?

Depende mucho del caso, si quieres cambiar toda la información de un registro, usa el metodo put, si quieres cambiar una propiedad especifica, usa el metodo patch.