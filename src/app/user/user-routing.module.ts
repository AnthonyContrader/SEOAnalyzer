import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { UserDashboardComponent } from './user-dashboard/user-dashboard.component';
import { UserLayoutComponent } from '../layout/user-layout/user-layout.component';
import { AnalyzeComponent } from './analyze/analyze.component';

/**
 * Modulo di routing dello user. Qui ci sono i percorsi che uno user può seguire:
 * appena fa il login viene caricato nel <router-outlet> di app-component il layout e nel 
 * <router-outlet> del layout (come percorsi "children") vengono visualizzati gli altri 
 * (qui sotto sono indentati).
 * 
 * @author Vittorio Valent
 * 
 * @see UserLayoutComponent
 * 
 * @see layout
 */
const routes: Routes = [
  { path: 'user-dashboard',component: UserLayoutComponent, children:[
    { path: '', component: UserDashboardComponent},
    { path: 'analyze', component: AnalyzeComponent}
  ]}
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class UserRoutingModule { }