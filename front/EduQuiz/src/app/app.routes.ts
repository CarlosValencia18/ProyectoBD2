import { Routes } from '@angular/router';
import { LoginComponent } from './pagina/login/login.component';
import {CrearExamenComponent} from "./pagina/crear-examen/crear-examen.component";
import {CrearPreguntaComponent} from "./pagina/crear-pregunta/crear-pregunta.component";
import {OpcionMultipleComponent} from "./pagina/opcion-multiple/opcion-multiple.component";
import {SeleccionarExamenComponent} from "./pagina/seleccionar-examen/seleccionar-examen.component";
import {InicioDocenteComponent} from "./pagina/inicio-docente/inicio-docente.component";
import {CrearBancoPreguntasComponent} from "./pagina/crear-banco-preguntas/crear-banco-preguntas.component";
import {MultipleRespuestaComponent} from "./pagina/multiple-respuesta/multiple-respuesta.component";
import {FalsoVerdaderoComponent} from "./pagina/falso-verdadero/falso-verdadero.component";

export const routes: Routes = [{
  path:'login',
  component: LoginComponent
},{path:'crear-examen',component:CrearExamenComponent
},{path:'crear-pregunta',component:CrearPreguntaComponent
},{path:'opcion-multiple',component:OpcionMultipleComponent
},{path:'seleccionar-examen',component:SeleccionarExamenComponent
},{path:'inicio-docente',component:InicioDocenteComponent
},{path:'crear-banco-preguntas',component:CrearBancoPreguntasComponent
},{path:'multiple-respuesta',component:MultipleRespuestaComponent
},{path:'falso-verdadero',component:FalsoVerdaderoComponent
}];
