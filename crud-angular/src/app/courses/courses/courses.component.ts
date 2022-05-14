import { CoursesService } from './../services/courses.service';
import { Component, OnInit } from '@angular/core';
import { Course } from '../model/course';
import { catchError, Observable, of } from 'rxjs';
import { MatDialog } from '@angular/material/dialog';
import { ErrorDialogComponent } from 'src/app/shared/components/error-dialog/error-dialog.component';

@Component({
  selector: 'app-courses',
  templateUrl: './courses.component.html',
  styleUrls: ['./courses.component.scss']
})
export class CoursesComponent implements OnInit {

  courses$: Observable<Course[]>;
  // courses: Course[] = [];
  displayedColumns = ['name','category'];

  // coursesService: CoursesService;

  constructor(
    private coursesService: CoursesService,
    public dialog: MatDialog
    ) {
    // this.courses = [];
    // this.coursesService = new CoursesService();
    this.courses$ = this.coursesService.list()
    .pipe( // o pipe que faz o tratamento de erro
        catchError (error => { // se quiser fazer o spinner parar precisa retornar dados, mesmo que vázio.
        this.onError('Erro ao carregar cursos.');
          return of([])
        })
    );

    // this.coursesService.list().subscribe(courses => this.courses = courses);
  }

  onError(errorMsg: string){
      this.dialog.open(ErrorDialogComponent, {
        data: errorMsg
      });
  }

  ngOnInit(): void {

  }

}
