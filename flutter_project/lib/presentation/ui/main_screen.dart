import 'package:flutter/material.dart';
import 'package:flutter_project/data/model/person_model.dart';
import 'package:flutter_project/presentation/ui/detail_screen.dart';
import 'package:flutter_project/presentation/viewmodel/person_viewmodel.dart';
import 'package:provider/provider.dart';

class MainScreen extends StatefulWidget {
  @override
  _MainScreenState createState() => _MainScreenState();
}

class _MainScreenState extends State<MainScreen> {
  PersonViewModel _personViewModel;

  _navigateToDetailScreen({PersonModel personModel}) {
    Navigator.of(context).push(
      MaterialPageRoute(
        builder: (context) => DetailScreen(personModel: personModel),
      ),
    );
  }

  @override
  void initState() {
    _personViewModel = context.read<PersonViewModel>();
    super.initState();
  }

  @override
  Widget build(BuildContext context) {
    context.watch<PersonViewModel>().retrievePeople(context: context);

    return Scaffold(
      appBar: AppBar(
        title: Text('Main Page'),
      ),
      body: Consumer<PersonViewModel>(
        builder: (context, personViewModel, child) {
          if (personViewModel.getMessage != null) {
            return Center(
              child: Text(personViewModel.getMessage),
            );
          } else if (personViewModel.getPeople == null) {
            return Center(
              child: CircularProgressIndicator(),
            );
          } else {
            if (personViewModel.getPeople.length > 0) {
              return ListView.builder(
                itemCount: personViewModel.getPeople.length,
                itemBuilder: (context, index) {
                  return Center(
                    child: Card(
                      elevation: 1,
                      child: ListTile(
                        onTap: () {
                          _navigateToDetailScreen(
                              personModel: personViewModel.getPeople[index]);
                        },
                        title: Text(personViewModel.getPeople[index].name),
                        trailing: IconButton(
                          onPressed: () {
                            _personViewModel.deletePerson(
                              personModel: personViewModel.getPeople[index],
                              context: context,
                            );
                          },
                          icon: Icon(Icons.delete),
                        ),
                      ),
                    ),
                  );
                },
              );
            } else {
              return Center(
                child: Text('Nothing here =/'),
              );
            }
          }
        },
      ),
      floatingActionButton: FloatingActionButton(
        onPressed: () {
          _navigateToDetailScreen();
        },
        child: Icon(Icons.add),
      ),
    );
  }
}
